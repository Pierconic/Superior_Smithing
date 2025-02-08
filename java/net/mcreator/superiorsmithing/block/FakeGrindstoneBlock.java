
package net.mcreator.superiorsmithing.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.superiorsmithing.world.inventory.FakeGrindingGUIMenu;
import net.mcreator.superiorsmithing.procedures.ReplaceLegacyGrindstoneProcedure;

import io.netty.buffer.Unpooled;

public class FakeGrindstoneBlock extends Block implements SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final EnumProperty<AttachFace> FACE = FaceAttachedHorizontalDirectionalBlock.FACE;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public FakeGrindstoneBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(2f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(FACE, AttachFace.WALL).setValue(WATERLOGGED, false));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return state.getFluidState().isEmpty();
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(2, 0, 6, 4, 7, 10), box(12, 0, 6, 14, 7, 10), box(2, 7, 5, 4, 13, 11), box(12, 7, 5, 14, 13, 11), box(4, 4, 2, 12, 16, 14));
				case WALL -> Shapes.or(box(2, 6, 0, 4, 10, 7), box(12, 6, 0, 14, 10, 7), box(2, 5, 7, 4, 11, 13), box(12, 5, 7, 14, 11, 13), box(4, 2, 4, 12, 14, 16));
				case CEILING -> Shapes.or(box(12, 9, 6, 14, 16, 10), box(2, 9, 6, 4, 16, 10), box(12, 3, 5, 14, 9, 11), box(2, 3, 5, 4, 9, 11), box(4, 0, 2, 12, 12, 14));
			};
			case NORTH -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(12, 0, 6, 14, 7, 10), box(2, 0, 6, 4, 7, 10), box(12, 7, 5, 14, 13, 11), box(2, 7, 5, 4, 13, 11), box(4, 4, 2, 12, 16, 14));
				case WALL -> Shapes.or(box(12, 6, 9, 14, 10, 16), box(2, 6, 9, 4, 10, 16), box(12, 5, 3, 14, 11, 9), box(2, 5, 3, 4, 11, 9), box(4, 2, 0, 12, 14, 12));
				case CEILING -> Shapes.or(box(2, 9, 6, 4, 16, 10), box(12, 9, 6, 14, 16, 10), box(2, 3, 5, 4, 9, 11), box(12, 3, 5, 14, 9, 11), box(4, 0, 2, 12, 12, 14));
			};
			case EAST -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(6, 0, 12, 10, 7, 14), box(6, 0, 2, 10, 7, 4), box(5, 7, 12, 11, 13, 14), box(5, 7, 2, 11, 13, 4), box(2, 4, 4, 14, 16, 12));
				case WALL -> Shapes.or(box(0, 6, 12, 7, 10, 14), box(0, 6, 2, 7, 10, 4), box(7, 5, 12, 13, 11, 14), box(7, 5, 2, 13, 11, 4), box(4, 2, 4, 16, 14, 12));
				case CEILING -> Shapes.or(box(6, 9, 2, 10, 16, 4), box(6, 9, 12, 10, 16, 14), box(5, 3, 2, 11, 9, 4), box(5, 3, 12, 11, 9, 14), box(2, 0, 4, 14, 12, 12));
			};
			case WEST -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(6, 0, 2, 10, 7, 4), box(6, 0, 12, 10, 7, 14), box(5, 7, 2, 11, 13, 4), box(5, 7, 12, 11, 13, 14), box(2, 4, 4, 14, 16, 12));
				case WALL -> Shapes.or(box(9, 6, 2, 16, 10, 4), box(9, 6, 12, 16, 10, 14), box(3, 5, 2, 9, 11, 4), box(3, 5, 12, 9, 11, 14), box(0, 2, 4, 12, 14, 12));
				case CEILING -> Shapes.or(box(6, 9, 12, 10, 16, 14), box(6, 9, 2, 10, 16, 4), box(5, 3, 12, 11, 9, 14), box(5, 3, 2, 11, 9, 4), box(2, 0, 4, 14, 12, 12));
			};
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, FACE, WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		return super.getStateForPlacement(context).setValue(FACE, faceForDirection(context.getNearestLookingDirection())).setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, flag);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	private AttachFace faceForDirection(Direction direction) {
		if (direction.getAxis() == Direction.Axis.Y)
			return direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR;
		else
			return AttachFace.WALL;
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}

	@Override
	public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
		return new ItemStack(Blocks.GRINDSTONE);
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		ReplaceLegacyGrindstoneProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		ReplaceLegacyGrindstoneProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		ReplaceLegacyGrindstoneProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		if (entity instanceof ServerPlayer player) {
			player.openMenu(new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("Fake Grindstone");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new FakeGrindingGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
				}
			}, pos);
		}
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		ReplaceLegacyGrindstoneProcedure.execute(world, x, y, z);
		return InteractionResult.SUCCESS;
	}
}
